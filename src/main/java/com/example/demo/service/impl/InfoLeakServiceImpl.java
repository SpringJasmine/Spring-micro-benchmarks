package com.example.demo.service.impl;

import com.example.demo.model.ModelOne;
import com.example.demo.service.InfoLeakService;
import com.example.demo.tag.InfoLeakTag;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


@Service
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class InfoLeakServiceImpl implements InfoLeakService {
    private static final Logger LOGGER = LoggerFactory.getLogger(InfoLeakServiceImpl.class);

    private static final String FILE_NAME = "ModelOne.txt";

    @InfoLeakTag(description = "")
    @Override
    public void infoLeakMethod(String token, String password, String id) {
        ModelOne modelOne = new ModelOne(token, password, id);
        //write data to ModelOne.txt finash Serialization
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(
                    new File(FILE_NAME)));
            out.writeObject(modelOne);
            LOGGER.info("ModelOne Object Serializable sucess");
        } catch (IOException e) {
            LOGGER.info("IOException");
        } finally {
            IOUtils.closeQuietly(out);
        }
    }

}
