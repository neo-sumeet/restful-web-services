package com.ss.restfulwebservices.responseFiltering.dynamicFiltering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class StudentDynamicFilterController {

    @GetMapping("dynamic/students")
    private MappingJacksonValue getStudentList(){

        List<Student> students = Arrays.asList(new Student(1, "John", "john@xyz.com",new Parent(10,"Jack")));

        FilterProvider filterProvider = new SimpleFilterProvider()
                .addFilter("StudentDynamicFilter", getFilter("id","name"));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(students);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }

    @GetMapping("dynamic/students/{id}")
    private MappingJacksonValue getStudent(@PathVariable("id") String id){
        Student student = new Student(1, "John", "john@xyz.com",new Parent(10,"Jack"));
        FilterProvider filterProvider = new SimpleFilterProvider()
                .addFilter("StudentDynamicFilter", getFilter("id","name","email","parent"))
                .addFilter("ParentFilter",getFilter("name"));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(student);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;

    }

    private SimpleBeanPropertyFilter getFilter(String... includePropertyNames) {
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept(includePropertyNames);
        return simpleBeanPropertyFilter;
    }
}
