package codegym.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Music {
    @Id
    private int id ;
    private String musicName ;
    private String singerName ;
    private String kindOfMusic ;
    private String music ;

    public Music() {
    }

    public Music(int id, String musicName, String singerName, String kindOfMusic, String music) {
        this.id = id;
        this.musicName = musicName;
        this.singerName = singerName;
        kindOfMusic = kindOfMusic;
        this.music = music;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        kindOfMusic = kindOfMusic;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }
}
