package com.marcofabbian.processor.input

import org.apache.commons.io.IOCase
import org.apache.commons.io.filefilter.NameFileFilter
import org.apache.commons.io.filefilter.NotFileFilter
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor
import org.apache.commons.io.monitor.FileAlterationMonitor
import org.apache.commons.io.monitor.FileAlterationObserver
import org.springframework.stereotype.Component
import java.io.File
import java.time.LocalTime
import kotlin.math.abs

@Component
class FileMonitor(
    private val config:FileMonitorConfig
) {
    private val monitor = FileAlterationMonitor(10000)
    private var files = mutableListOf<File>()

    fun run(function:(file:File)->Unit) {
        var time = LocalTime.now()
        var difference = 0
        var observer = FileAlterationObserver(File(config.sourcePath), NotFileFilter(NameFileFilter(".DS_Store")), IOCase.INSENSITIVE)
        monitor.start()
        monitor.addObserver(observer)
        observer.addListener(object: FileAlterationListenerAdaptor(){
            override fun onFileCreate(file: File?) {
                if(file != null && !files.contains(file)){
                    super.onFileCreate(file)
                    files.add(file)
                    function(file)
                }
            }
        })
        while (difference < 4) {
            // While condition
            difference = abs(time.minute -LocalTime.now().minute)
        }
        monitor.stop()
    }

    fun remove(file:File) = files.remove(file)
}