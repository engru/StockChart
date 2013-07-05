package com.example.graphics.coverage.dispatch;

import java.util.List;

import com.example.graphics.coverage.entity.Data;

public interface IHandleData {
	void onInterceptData(Data d);
	void onData(Data d);
}
