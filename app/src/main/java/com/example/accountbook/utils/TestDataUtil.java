package com.example.accountbook.utils;


import com.example.accountbook.bean.TallyDetailBean;
import com.example.accountbook.bean.TallyNoteBean;
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


    //记一笔支出假数据
    public static TallyNoteBean getTallyNoteBeanOut(){
        String str= "{\n" +
                "    \"status\":1,\n" +
                "    \"sortlist\":[\n" +
                "        {\n" +
                "            \"sort_id\":\"301\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"偿还费用\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/changhuanfeiyong@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"302\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"手续费\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/shouxufei@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"303\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"商城消费\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/shangchengxiaofei@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"304\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"违约金\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/weiyuejin@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"305\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"住房\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/zhufang@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"306\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"办公\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/bangong@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"307\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"餐饮\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/canyin@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"308\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"医疗\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/yiliao@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"309\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"通讯\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/tongxun@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"310\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"运动\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/yundong@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"311\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"娱乐\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/yule@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"312\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"居家\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/jujia@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"313\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"宠物\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/chongwu@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"314\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"数码\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/shuma@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"315\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"捐赠\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/juanzeng@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"316\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"零食\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/lingshi@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"317\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"孩子\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/haizi@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"318\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"长辈\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/zhangbei@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"319\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"礼物\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/liwu@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"320\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"学习\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/xuexi@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"321\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"水果\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/shuiguo@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"322\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"美容\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/meirong@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"323\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"维修\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/weixiu@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"324\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"旅行\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/lvxing@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"325\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"交通\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/jiaotong@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"326\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"饮料\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/jiushuiyinliao@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"327\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"礼金\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/lijin@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"0\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"添加\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/tianjia@2x.png\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"payinfo\":[\n" +
                "        {\n" +
                "            \"pay_type\":\"1\",\n" +
                "            \"pay_name\":\"现金\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"pay_type\":\"3_28\",\n" +
                "            \"pay_name\":\"银行卡\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"pay_type\":\"3_22\",\n" +
                "            \"pay_name\":\"支付宝\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"pay_type\":\"3_10\",\n" +
                "            \"pay_name\":\"微信\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        return new Gson().fromJson(str, TallyNoteBean.class);
    }


    //记一笔收入假数据
    public static TallyNoteBean getTallyNoteBeanIn(){
        String str= "{\n" +
                "    \"status\":1,\n" +
                "    \"sortlist\":[\n" +
                "        {\n" +
                "            \"sort_id\":\"328\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"礼金\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/lijin@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"329\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"加息\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/jiaxi@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"330\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"佣金奖励\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/yongjinjiangli@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"331\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"额外收益\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/ewaishouyi@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"332\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"资金补偿\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/zijinbuchang@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"333\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"利息\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/lixi@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"334\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"返现\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/fanxian@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"335\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"兼职\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/jianzhi@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"336\",\n" +
                "            \"uid\":\"262\",\n" +
                "            \"sort_name\":\"其他\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/tianjiade@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"339\",\n" +
                "            \"uid\":\"262\",\n" +
                "            \"sort_name\":\"添加3\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/tianjiade@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"348\",\n" +
                "            \"uid\":\"262\",\n" +
                "            \"sort_name\":\"吃饭\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/tianjiade@2x.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sort_id\":\"0\",\n" +
                "            \"uid\":\"0\",\n" +
                "            \"sort_name\":\"添加\",\n" +
                "            \"sort_img\":\"/UF/Uploads/Noteimg/blacksort/tianjia@2x.png\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"payinfo\":[\n" +
                "        {\n" +
                "            \"pay_type\":\"1\",\n" +
                "            \"pay_name\":\"现金\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"pay_type\":\"3_29\",\n" +
                "            \"pay_name\":\"银行卡、\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"pay_type\":\"3_28\",\n" +
                "            \"pay_name\":\"支付宝\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"pay_type\":\"4\",\n" +
                "            \"pay_name\":\"未分类\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        return new Gson().fromJson(str, TallyNoteBean.class);
    }














}
