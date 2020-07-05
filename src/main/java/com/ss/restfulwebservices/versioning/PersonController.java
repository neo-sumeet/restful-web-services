package com.ss.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("v1/person")
    public PersonV1 uriVersioningV1(){
        return new PersonV1("John Doe");
    }

    @GetMapping("v2/person")
    public PersonV2 uriVersioningV2(){
        return new PersonV2(new Name("John","Doe"));
    }

    @GetMapping(value = "person",headers = "X-API-VERSION=1")
    public PersonV1 headerVersioningV1(){
        return new PersonV1("John Doe");
    }

    @GetMapping(value = "person",headers = "X-API-VERSION=2")
    public PersonV2 headerVersioningV2(){
        return new PersonV2(new Name("John","Doe"));
    }

    @GetMapping(value = "person",produces = "application/com.ss.restfulwebservices.v1+json")
    public PersonV1 mimeVersioningV1(){
        return new PersonV1("John Doe");
    }

    @GetMapping(value = "person",produces = "application/com.ss.restfulwebservices.v2+json")
    public PersonV2 mimeVersioningV2(){
        return new PersonV2(new Name("John","Doe"));
    }

    @GetMapping(value = "person",params = "version=1")
    public PersonV1 paramVersioningV1(){
        return new PersonV1("John Doe");
    }

    @GetMapping(value = "person",params = "version=2")
    public PersonV2 paramVersioningV2(){
        return new PersonV2(new Name("John","Doe"));
    }
}
