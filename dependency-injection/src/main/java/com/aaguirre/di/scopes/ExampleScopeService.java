package com.aaguirre.di.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

//Default scope is singleton
@Scope("prototype")

@Service
public class ExampleScopeService {

}
