package org.wzx.cloud.service;

import java.util.Map;

public interface SystemService {

    Map<String, String> listConst() throws Exception;

    void saveConst(Map<String, String> map) throws Exception;

    void refreshMovieList() throws Exception;
}
