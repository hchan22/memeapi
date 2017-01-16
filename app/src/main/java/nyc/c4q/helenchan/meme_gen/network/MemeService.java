package nyc.c4q.helenchan.meme_gen.network;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by helenchan on 1/9/17.
 * http://version1.api.memegenerator.net/Generators_Select_ByPopular?pageIndex=0&pageSize=12&days=
 */

public interface MemeService {
    @GET("get_memes")
    Call<MemeResponse> getMemememe();
}
