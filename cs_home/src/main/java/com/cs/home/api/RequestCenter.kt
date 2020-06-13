package com.cs.home.api

import com.cs.home.model.home.Banner
import com.cs.home.model.home.DataFeed
import com.cs.home.model.home.Weather
import com.cs.home.model.navigation.NavigationItem
import com.cs.home.model.project.ProjectPageItem
import com.cs.home.model.project.ProjectTabItem
import com.cs.home.model.tree.TreeData
import com.cs.lib_net.model.BaseModel
import com.cs.lib_net.model.BaseTXApiModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Create by liwen on 2020-05-18
 */
interface RequestCenter {

    /**
     * IT资讯   http://api.tianapi.com/it/index
     */
    @GET("/it/index")
    suspend fun getITNewsList(
        @Query("key") key: String,
        @Query("num") num: Int,
        @Query("page") page: Int
    ): BaseTXApiModel<MutableList<DataFeed>>

    /**
     * 天气预报   http://api.tianapi.com/txapi/tianqi/index?key=APIKEY&city=上海
     */
    @GET("/txapi/tianqi/index")
    suspend fun getWeather(
        @Query("key") key: String,
        @Query("city") city: String
    ): BaseTXApiModel<MutableList<Weather>>

    @GET("/banner/json")
    suspend fun getBanner(): BaseModel<MutableList<Banner>>

    // 视频分类推荐列表
    @GET("/videoCategory")
    suspend fun getVideoCategory(): BaseModel<MutableList<Banner>>

    // 视频分类推荐详情列表
    @GET("/videoCategoryDetails")
    suspend fun getVideoCategoryDetail(
        @Query("id") id: Int
    ): BaseTXApiModel<MutableList<Weather>>

    @GET("/article/list/{count}/json")
    suspend fun getHomeList(@Path("count") count: Int): BaseModel<DataFeed>

    @GET("/tree/json")
    suspend fun getTreeList(): BaseModel<MutableList<TreeData>>

    @GET("/project/tree/json")
    suspend fun getTabData(): BaseModel<MutableList<ProjectTabItem>>

    @GET("/project/list/{count}/json")
    suspend fun getTabItemPageData(
        @Path("count") count: Int,
        @Query("cid") cid: Int
    ): BaseModel<ProjectPageItem>

    @GET("/navi/json")
    suspend fun getNavigationData(): BaseModel<MutableList<NavigationItem>>

}