package com.win.ft_home.model.home

/**
 * {
"area":"北京",
"date":"2020-03-23",
"week":"星期二",
"weather":"晴转多云",
"weatherimg":"yun.png",
"real":"18℃",
"lowest":"6℃",
"highest":"22℃",
"wind":"东北风",
"winddeg": "121",
"windspeed":"7",
"windsc":"1-2级",
"sunrise":"06:10",
"sunset":"18:31",
"moonrise":"06:02",
"moondown":"17:22",
"pcpn":"0.0",
"pop":"1",
"uv_index":"9",
"vis":"25",
"humidity":"23",
"tips":"天气暖和，适宜着单层棉麻面料的短套装、T恤衫、薄牛仔衫裤、休闲服、职业套装等春秋过渡装。年老体弱者请适当增减衣服。"
}
 */
data class Weather(
    val area: String,
    val date: String,
    val week: String,
    val weather: String,
    val weatherimg: String,
    val real: String,
    val lowest: String,
    val highest: String,
    val wind: String,
    val winddeg: String,
    val windspeed: String,
    val windsc: String,
    val sunrise: String,
    val sunset: String,
    val moonrise: String,
    val moondown: String,
    val pcpn: String,
    val pop: String,
    val uv_index: String,
    val vis: String,
    val humidity: String,
    val tips: String
)