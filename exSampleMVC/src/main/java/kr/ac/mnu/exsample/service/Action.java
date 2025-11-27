package kr.ac.mnu.exsample.service;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public void process(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException;
}

