package com.example.graphics.layers.dispatch;

import java.util.List;

import com.example.graphics.layers.entity.Data;

public interface IHandleData {
	void onInterceptData(Data d);
	void onData(Data d);
}
