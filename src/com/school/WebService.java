package com.school;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.school.helper.FileHelper;

@Api(name = "webservice", version = "v1")
public class WebService {
  

  @ApiMethod(name = "getSchoolsData", httpMethod = HttpMethod.GET)
  public List<Map<String, String>> getSchoolsData(HttpServletRequest request, ServletContext sc) {
    return FileHelper.getSchoolData(sc);
  }
}
