package com.marcofabbian.processor.input

import org.apache.commons.io.IOCase
import org.apache.commons.io.filefilter.NameFileFilter
import org.apache.commons.io.filefilter.NotFileFilter
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor
import org.apache.commons.io.monitor.FileAlterationMonitor
import org.apache.commons.io.monitor.FileAlterationObserver
import org.springframework.stereotype.Component
import java.io.File
import java.nio.file.Path
import java.time.LocalTime
import kotlin.math.abs

@Component
class FileMonitor(
    private val config:FileMonitorConfig
) {
    private val monitor = FileAlterationMonitor(config.interval)
    private var files = mutableListOf<File>()

    fun run(function:(file:File)->Unit) {
        var time = LocalTime.now()
        var observer = FileAlterationObserver(File(config.path), NotFileFilter(NameFileFilter(".DS_Store")), IOCase.INSENSITIVE)
        monitor.start()
        monitor.addObserver(observer)
        observer.addListener(object: FileAlterationListenerAdaptor(){
            override fun onFileCreate(file: File?) {
                if(file != null && !files.contains(file)){
                    val newFile = move(file)
                    super.onFileCreate(newFile)
                    files.add(newFile)
                    function(newFile)
                }
            }
        })
        while (abs(time.minute - LocalTime.now().minute) < 4) {
            // While condition
        }
        monitor.stop()
    }

    fun move(file:File):File {
        val newFileName = Path.of(config.inProgressPath, file.name).toString()
        val newFile = File(newFileName)
        file.copyTo(newFile, true)
        return newFile
    }
}