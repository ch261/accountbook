package com.example.accountbook.utils;


import com.example.accountbook.bean.TallyDetailBean;
import com.google.gson.Gson;

/**
 * Created by Administrator on 2017/10/24 0024.
 */

public class TestDataUtil {


    //明细假数据
    public static TallyDetailBean getTallyDetailBean(){
        String str= "{\n" +
                "    \"status\":1,\n" +
                "    \"t_income\":\"88,929.42\",\n" +
                "    \"t_outcome\":\"18,270.36\",\n" +
                "    \"daylist\":[\n" +
                "        {\n" +
                "            \"time\":\"27日-星期五\",\n" +
                "            \"money\":\"支出：1268.00 收入：0.00\",\n" +
                "            \"list\":[\n" +
                "                {\n" +
                "                    \"id\":\"185\",\n" +
                "                    \"affect_money\":\"-25.00\",\n" +
                "                    \"typename\":\"餐饮\",\n" +
                "                    \"img\":\"/UF/Uploads/Noteimg/listout/canyin@2x.png\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\":\"184\",\n" +
                "                    \"affect_money\":\"-360.00\",\n" +
                "                    \"typename\":\"餐饮\",\n" +
                "                    \"img\":\"/UF/Uploads/Noteimg/listout/canyin@2x.png\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\":\"183\",\n" +
                "                    \"affect_money\":\"-12.00\",\n" +
                "                    \"typename\":\"餐饮\",\n" +
                "                    \"img\":\"/UF/Uploads/Noteimg/listout/canyin@2x.png\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\":\"182\",\n" +
                "                    \"affect_money\":\"-699.00\",\n" +
                "                    \"typename\":\"餐饮\",\n" +
                "                    \"img\":\"/UF/Uploads/Noteimg/listout/canyin@2x.png\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\":\"171\",\n" +
                "                    \"affect_money\":\"-300.00\",\n" +
                "                    \"typename\":\"发红包\",\n" +
                "                    \"img\":\"/UF/Uploads/Noteimg/listout/tianjiade@2x.png\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"time\":\"24日-星期二\",\n" +
                "            \"money\":\"支出：0.00 收入：8888.00\",\n" +
                "            \"list\":[\n" +
                "                {\n" +
                "                    \"id\":\"89\",\n" +
                "                    \"affect_money\":\"+8888.00\",\n" +
                "                    \"typename\":\"工资\",\n" +
                "                    \"img\":\"/UF/Uploads/Noteimg/listin/fanxian@2x.png\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"time\":\"20日-星期五\",\n" +
                "            \"money\":\"支出：0.00 收入：37.11\",\n" +
                "            \"list\":[\n" +
                "                {\n" +
                "                    \"id\":\"sys_17701\",\n" +
                "                    \"affect_money\":\"+0.03\",\n" +
                "                    \"typename\":\"额外收益\",\n" +
                "                    \"img\":\"/UF/Uploads/Noteimg/listin/ewaishouyi@2x.png\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\":\"sys_17699\",\n" +
                "                    \"affect_money\":\"+0.15\",\n" +
                "                    \"typename\":\"额外收益\",\n" +
                "                    \"img\":\"/UF/Uploads/Noteimg/listin/ewaishouyi@2x.png\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\":\"sys_17683\",\n" +
                "                    \"affect_money\":\"+0.03\",\n" +
                "                    \"typename\":\"额外收益\",\n" +
                "                    \"img\":\"/UF/Uploads/Noteimg/listin/ewaishouyi@2x.png\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\":\"sys_17462\",\n" +
                "                    \"affect_money\":\"+9.63\",\n" +
                "                    \"typename\":\"待收利息\",\n" +
                "                    \"img\":\"/UF/Uploads/Noteimg/listin/lixi@2x.png\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\":\"sys_17463\",\n" +
                "                    \"affect_money\":\"+0.54\",\n" +
                "                    \"typename\":\"待收利息\",\n" +
                "                    \"img\":\"/UF/Uploads/Noteimg/listin/lixi@2x.png\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\":\"sys_17466\",\n" +
                "                    \"affect_money\":\"+0.09\",\n" +
                "                    \"typename\":\"待收利息\",\n" +
                "                    \"img\":\"/UF/Uploads/Noteimg/listin/lixi@2x.png\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"time\":\"16日-星期一\",\n" +
                "            \"money\":\"支出：0.00 收入：0.60\",\n" +
                "            \"list\":[\n" +
                "                {\n" +
                "                    \"id\":\"sys_17437\",\n" +
                "                    \"affect_money\":\"+0.15\",\n" +
                "                    \"typename\":\"额外收益\",\n" +
                "                    \"img\":\"/UF/Uploads/Noteimg/listin/ewaishouyi@2x.png\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\":\"sys_17428\",\n" +
                "                    \"affect_money\":\"+0.20\",\n" +
                "                    \"typename\":\"额外收益\",\n" +
                "                    \"img\":\"/UF/Uploads/Noteimg/listin/ewaishouyi@2x.png\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\":\"sys_17418\",\n" +
                "                    \"affect_money\":\"+0.05\",\n" +
                "                    \"typename\":\"额外收益\",\n" +
                "                    \"img\":\"/UF/Uploads/Noteimg/listin/ewaishouyi@2x.png\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"time\":\"13日-星期五\",\n" +
                "            \"money\":\"支出：0.00 收入：0.43\",\n" +
                "            \"list\":[\n" +
                "                {\n" +
                "                    \"id\":\"sys_17400\",\n" +
                "                    \"affect_money\":\"+0.18\",\n" +
                "                    \"typename\":\"额外收益\",\n" +
                "                    \"img\":\"/UF/Uploads/Noteimg/listin/ewaishouyi@2x.png\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        return new Gson().fromJson(str, TallyDetailBean.class);
    }















}
