package com.amazon.ata.music.playlist.service.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Objects;

/**
 * Represents a record in the album_tracks table.
 */
@DynamoDBTable(tableName = "album_tracks")
public class AlbumTrack {
    private String asin;
    private Integer trackNumber;
    private String albumName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumTrack that = (AlbumTrack) o;
        return Objects.equals(asin, that.asin) && Objects.equals(trackNumber, that.trackNumber) && Objects.equals(albumName, that.albumName) && Objects.equals(songTitle, that.songTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(asin, trackNumber, albumName, songTitle);
    }

    private String songTitle;
    @DynamoDBHashKey(attributeName = "asin")
    public String getAsin() {
        return asin;
    }

    @Override
    public String toString() {
        return "AlbumTrack{" +
                "asin='" + asin + '\'' +
                ", trackNumber=" + trackNumber +
                ", albumName='" + albumName + '\'' +
                ", songTitle='" + songTitle + '\'' +
                '}';
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }
    @DynamoDBRangeKey(attributeName = "trackNumber")
    public Integer getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }
}
