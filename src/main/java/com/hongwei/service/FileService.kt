package com.hongwei.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.lang.RuntimeException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption


@Service
class FileService {
    @Value("\${app.upload.dir:\${user.home}}")
    var uploadDir: String? = null
    fun uploadFile(file: MultipartFile) {

        print("bbbb uploadDir: $uploadDir")

        try {
            val copyLocation: Path = Paths
                    .get(uploadDir + File.separator + StringUtils.cleanPath(file.originalFilename))
            Files.copy(file.inputStream, copyLocation, StandardCopyOption.REPLACE_EXISTING)
        } catch (e: Exception) {
            e.printStackTrace()
            throw RuntimeException("Could not store file " + file.originalFilename
                    + ". Please try again!")
        }
    }
}