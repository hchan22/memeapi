package nyc.c4q.helenchan.meme_gen.network;

/**
 * Created by helenchan on 1/9/17.
 * {
 * "success": true,
 * "data": {
 * "memes": [{
 * "id": "61579",
 * "name": "One Does Not Simply",
 * "url": "https:\/\/i.imgflip.com\/1bij.jpg",
 * "width": 568,
 * "height": 335
 * },
 */

public class MemeResponse {
    private boolean success;
    private Data data;

    public boolean isSuccess() {
        return success;
    }

    public Data getData() {
        return data;
    }
}
