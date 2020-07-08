package com.qin.myspringboot.config;

import freemarker.template.DefaultObjectWrapper;
import freemarker.template.SimpleDate;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


/**
 * freemarker格式化java8新增的日期格式
 */
@Component
public class FreemarkerConfig {
    @Autowired
    public void configureFreemarker(freemarker.template.Configuration configuration) {
        configuration.setObjectWrapper(new DefaultObjectWrapper(freemarker.template.Configuration.VERSION_2_3_28) {

            @Override
            public TemplateModel wrap(Object object) throws TemplateModelException {
                if (object instanceof LocalDate) {
                    return new SimpleDate(Date.valueOf((LocalDate) object));
                }
                if (object instanceof LocalTime) {
                    return new SimpleDate(Time.valueOf((LocalTime) object));
                }
                if (object instanceof LocalDateTime) {
                    return new SimpleDate(Timestamp.valueOf((LocalDateTime) object));
                }
                return super.wrap(object);
            }

        });
    }
}
