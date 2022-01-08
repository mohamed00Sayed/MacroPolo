package com.sayed.macropolo.config;

import java.util.regex.Pattern;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import com.sayed.macropolo.config.RootConfig.WebPackage;

@Configuration
@ComponentScan(basePackages={"com.sayed.macropolo"}, 
    excludeFilters={
        @Filter(type=FilterType.CUSTOM, value=WebPackage.class)
    })
public class RootConfig {
  public static class WebPackage extends RegexPatternTypeFilter {
    public WebPackage() {
      super(Pattern.compile("com\\.sayed\\.macropolo\\.web"));
    }    
  }
}
