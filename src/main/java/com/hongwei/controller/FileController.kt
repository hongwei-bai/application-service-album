package com.hongwei.controller

import com.hongwei.service.FileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.mvc.support.RedirectAttributes


@RestController
@RequestMapping("/file")
@CrossOrigin
class FileController {
    @Autowired
    var fileService: FileService? = null

    @Value("\${app.upload.dir:\${user.home}\\hongwei-service-files}")
    var uploadDir: String? = null

    @GetMapping("/")
    fun index(): String {
        return "upload dir: $uploadDir"
    }

    @PostMapping("/uploadFile")
    fun uploadFile(@RequestParam("file") file: MultipartFile, redirectAttributes: RedirectAttributes): String {
        fileService?.apply {
            uploadFile(file)
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded " + file.originalFilename + "!")
        }
        return "redirect:/"
    }
}