package day08.collection.song;

import util.Utility;

import java.util.*;

public class ArtistRepository {

    // key: 가수 이름, value: 가수 객체
    private static Map<String, Artist> artistList;

    static {
        artistList = new HashMap<>();
    }

    int enteredArtists() {
        return artistList.size();
    }


    public void addArtist(String name, Set<String> songList) {
        Artist artist = new Artist(name, songList);
        artistList.put(name, artist);
    }

    public Artist getArtistByName(String name) {
        return artistList.get(name);
    }

    public boolean isSongAlreadyRegistered(String artistName, String song) {
        Artist artist = artistList.get(artistName);
        if (artist != null) {
            Set<String> songList = artist.getSongList();
            return songList.contains(song);
        }
        return false;
    }

    public void showSong(String searchKeyWord) {
        Set<String> keySet = artistList.keySet();
        System.out.printf("\n# %s님의 노래목록\n", searchKeyWord);
        Utility.makeLine();
        Set<String> temp;
        String[] srr;
        int count = 1;
        if (enteredArtists() != 0) {
            for (String s : keySet) {
                if (s.equals(searchKeyWord)) {
                    temp = artistList.get(s).getSongList();
                    srr = temp.toArray(new String[0]);
                    for (String string : srr) {
                        System.out.printf("* %d. %s\n", count, string);
                        count++;
                    }
                    return;
                }
            }
            System.out.println("# 해당 가수는 등록되지 않았습니다.\n");
        } else {
            System.out.println("# 가수 목록이 비어 있습니다.\n");
        }
    }

    public void addSong(String name, String song) {
        if (isSongAlreadyRegistered(name, song)) {
            System.out.printf("\n# %s곡은 이미 등록된 노래입니다.", song);
        } else {
            Artist existingArtist = getArtistByName(name);
            if (existingArtist != null) {
                Set<String> songList = existingArtist.getSongList();
                songList.add(song);
                System.out.printf("# %s님의 노래목록에 %s곡이 추가 되었습니다\n", name, song);
            } else {
                Set<String> songList = new HashSet<>();
                songList.add(song);
                addArtist(name, songList);
                System.out.printf("# %s님이 신규 등록 되었습니다\n", name);
            }
        }
    }
}
