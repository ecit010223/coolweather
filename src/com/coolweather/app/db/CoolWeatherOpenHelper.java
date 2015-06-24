package com.coolweather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CoolWeatherOpenHelper extends SQLiteOpenHelper {
	private static final String CREATE_PROVINCE = "create table Province(id integer primary key "
			+ "autoincrement, province_name text,province_code text)";
	private static final String CREATE_CITY = "create table City(id integer primary key "
			+ "autoincrement, city_name text,city_code text,province_id integer)";
	private static final String CREATE_COUNTY = "create table County(id integer primary key "
			+ "autoincrement,county_name text,county_code text,city_id integer)";
	
	private static final String DROP_PROVINCE = "drop table if exists Province";
	private static final String DROP_CITY = "drop table if exists City";
	private static final String DROP_COUNTY = "drop table if exists County";

	public CoolWeatherOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_PROVINCE);
		db.execSQL(CREATE_CITY);
		db.execSQL(CREATE_COUNTY);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(DROP_PROVINCE);
		db.execSQL(DROP_CITY);
		db.execSQL(DROP_COUNTY);
		onCreate(db);
	}
}
