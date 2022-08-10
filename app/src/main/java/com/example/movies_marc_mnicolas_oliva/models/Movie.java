package com.example.movies_marc_mnicolas_oliva.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
/*
  "results": [
    {
      "adult": false,
      "backdrop_path": "/p1F51Lvj3sMopG948F5HsBbl43C.jpg",
      "genre_ids": [
        28,
        12,
        14
      ],
      "id": 616037,
      "original_language": "en",
      "original_title": "Thor: Love and Thunder",
      "overview": "After his retirement is interrupted by Gorr the God Butcher, a galactic killer who seeks the extinction of the gods, Thor enlists the help of King Valkyrie, Korg, and ex-girlfriend Jane Foster, who now inexplicably wields Mjolnir as the Mighty Thor. Together they embark upon a harrowing cosmic adventure to uncover the mystery of the God Butcher’s vengeance and stop him before it’s too late.",
      "popularity": 10909.273,
      "poster_path": "/pIkRyD18kl4FhoCNQuWxWu5cBLM.jpg",
      "release_date": "2022-07-08",
      "title": "Thor: Love and Thunder",
      "video": false,
      "vote_average": 6.8,
      "vote_count": 1731
    },
    ...
    ]
 */
public class Movie {
    private String title;
    private String overview;

    @SerializedName("poster_path")
    private String imgUrl;

    private int id;
    private Date release_date;
    private double vote_average;

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public int getId() {
        return id;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public double getVote_average() {
        return vote_average;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", id=" + id +
                ", release_date=" + release_date +
                ", vote_average=" + vote_average +
                '}';
    }
}
