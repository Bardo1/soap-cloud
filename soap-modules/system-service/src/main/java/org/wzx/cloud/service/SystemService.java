package org.wzx.cloud.service;

import java.util.Map;

public interface SystemService {

    Map<String, String> listConst() throws Exception;

    void saveConst(Map<String, String> map) throws Exception;

    boolean refreshMovieList() throws Exception;
}
