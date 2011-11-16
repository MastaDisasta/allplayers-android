package com.allplayers.android;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

public class AlbumsMap
{
	private ArrayList<AlbumData> albums = new ArrayList<AlbumData>();
	
	public AlbumsMap(String jsonResult)
	{
		try
		{
			JSONArray jsonArray = new JSONArray(jsonResult);
			
			if(jsonArray.length() > 0)
			{
				for(int i = 0; i < jsonResult.length(); i++)
				{
					albums.add(new AlbumData(jsonArray.getString(i)));
				}
			}
		}
		catch(JSONException ex)
		{
			System.out.println(ex);
		}
	}
	
	public ArrayList<AlbumData> getAlbumData()
	{
		return albums;
	}
}