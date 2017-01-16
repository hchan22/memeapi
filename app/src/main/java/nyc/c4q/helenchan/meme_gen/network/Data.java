package nyc.c4q.helenchan.meme_gen.network;

import java.util.List;

/**
 * Created by helenchan on 1/10/17.
 * {
 "success": true,
 "data": {
 "memes": [{
 "id": "61579",
 "name": "One Does Not Simply",
 "url": "https:\/\/i.imgflip.com\/1bij.jpg",
 "width": 568,
 "height": 335
 },
 */

public class Data {
    private List<Meme> memes;

    public List<Meme> getMemes() {
        return memes;
    }
}
