package com.wangdh.learner.base;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试String常量池的位置
 * <br/> JVM参数：-Xmx5m -XX:MaxPermSize=5m
 * </br/> 1.7及以上，抛出 java.lang.OutOfMemoryError: Java heap space,证明常量池在堆中
 */
public class StringInternOOM {
    public static void main(String[] args){
        // 以下代码测试String常量池所在的区域
        // 异常抛出的区域，即为常量所在内存区
//        List<String> list = new ArrayList<>();
//        int i = 0;
//        while (true){
//            list.add(String.valueOf(i++).intern());
//        }

        String a = "%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%3Csysmessage%3E%3Ctype%3E1%3C%2Ftype%3E%3Capp_id%3E922%3C%2Fapp_id%3E%3Cuid%3E124446844%3C%2Fuid%3E%3CsaveOffline%3E1%3C%2FsaveOffline%3E%3Cmessage%3E%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%3Csysmessage%3E%3Cdisplay_type%3E100%3C%2Fdisplay_type%3E%3Cnew_style%3E1%3C%2Fnew_style%3E%3Cmessage%3E%3Cpoptype%3Ecommon_pop%3C%2Fpoptype%3E%3Ceffecttype%3EFadeEffect%3C%2Feffecttype%3E%3Cclosetime%3E0%3C%2Fclosetime%3E%3Cstyle%3ERightBottomDirection%3C%2Fstyle%3E%3Cwidth%3E280%3C%2Fwidth%3E%3Cheight%3E265%3C%2Fheight%3E%3Ctitle+textColor%3D%220%2C0%2C0%22%3E%E8%B6%85%E7%8E%A9%E4%BC%9A%E5%91%98%E5%85%91%E6%8D%A2%3C%2Ftitle%3E%3Ccontext+actionClose%3D%22true%22+actionLogin%3D%22false%22%3E%3C%21%5BCDATA%5B+%3Chtml%3E%3Chead%3E%3Cmeta+http-equiv%3D%22Content-Language%22+content%3D%22zh-cn%22%3E%3Cmeta+http-equiv%3D%22Content-Type%22+content%3D%22text%2Fhtml%3B+charset%3Dgb2312%22%3E%3Cstyle+type%3D%22text%2Fcss%22%3E+a%3Alink+%7B+text-decoration%3A+none%3Bcolor%3A+black%7D++a%3Aactive+%7B+text-decoration%3Aunderline%7D++a%3Ahover+%7B+text-decoration%3Aunderline%3Bcolor%3A+red%7D+body%7Bmargin%3A0px%7D++a%3Avisited+%7B+text-decoration%3A+underline%3Bcolor%3A+black%7D+%3C%2Fstyle%3E%3C%2Fhead%3E%3Cbody%3E%3Ca+href%3D%22http%3A%2F%2Fgamevip.yy.com%2Fuser-center.html%3Frso%3Dchaowantc%22%3E%3Cdiv%3E%3Cimg+style%3D%22height%3A130px%3B%22+src%3D%22http%3A%2F%2Fdownload.game.yy.com%2Frequirement_new%2F20180622%2F14a34fe8c42ffee8%2FVip1.png%22%2F%3E%3C%2Fdiv%3E%3C%2Fa%3E%3C%2Fbody%3E%3C%2Fhtml%3E+%5D%5D%3E%3C%2Fcontext%3E%3Cbgcolor%3E6699BB%3C%2Fbgcolor%3E%3CbuttonItemSpace%3E0%3C%2FbuttonItemSpace%3E%3CyesButton+action%3D%22http%3A%2F%2Fgamevip.yy.com%2Fuser-center.html%3Frso%3Dchaowantc%22+actionClose%3D%22true%22+actionLogin%3D%22false%22%3E%E6%9F%A5%E7%9C%8B%3C%2FyesButton%3E%3Cdownload%3E%3Citem+md5%3D%220d4d1eafe1db02045a8e6b017151685d%22%3Ehttp%3A%2F%2Fdownload.game.yy.com%2Frequirement_new%2F20180622%2F14a34fe8c42ffee8%2FVip1.png%3C%2Fitem%3E%3C%2Fdownload%3E%3C%2Fmessage%3E%3C%2Fsysmessage%3E%3C%2Fmessage%3E%3C%2Fsysmessage%3E";
        String source = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><sysmessage><type>1</type><app_id>922</app_id><uid>50020058</uid><saveOffline>1</saveOffline><message><?xml version=\"1.0\" encoding=\"UTF-8\"?><sysmessage><display_type>100</display_type><new_style>1</new_style><message><poptype>common_pop</poptype><effecttype>FadeEffect</effecttype><closetime>0</closetime><style>RightBottomDirection</style><width>280</width><height>241</height><title textColor=\"0,0,0\">超玩会员兑换</title><context actionClose=\"true\" actionLogin=\"false\"><![CDATA[ <html><head><meta http-equiv=\"Content-Language\" content=\"zh-cn\"><meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\"><style type=\"text/css\"> a:link { text-decoration: none;color: black}  a:active { text-decoration:underline}  a:hover { text-decoration:underline;color: red} body{margin:0px}  a:visited { text-decoration: underline;color: black} </style></head><body><a href=\"http://gamevip.yy.com/user-center.html?rso=chaowantc\"><div><img src=\"http://download.game.yy.com/requirement_new/20180822/5c5ac72e78b4b892/Vip4.png\"/></div></a></body></html> ]]></context><bgcolor>6699BB</bgcolor><buttonItemSpace>0</buttonItemSpace><yesButton action=\"http://gamevip.yy.com/user-center.html?rso=chaowantc\" actionClose=\"true\" actionLogin=\"false\">查看</yesButton><download><item md5=\"ed59d552db14a3a38c773453493f7665\">http://download.game.yy.com/requirement_new/20180822/5c5ac72e78b4b892/Vip4.png</item></download></message></sysmessage></message></sysmessage>";




        String b = urlDecode(a);
        System.out.println(b);
//        System.out.println(urlEncode(b));

        System.out.println(urlEncode(source));




    }

    public static String urlDecode(String str) {
        if (str == null) {
            return null;
        } else {
            try {
                return URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException var2) {
                throw new RuntimeException(var2.getMessage(), var2);
            }
        }
    }

    public static String urlEncode(String str) {
        if (str == null) {
            return null;
        } else {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException var2) {
                throw new RuntimeException(var2.getMessage(), var2);
            }
        }
    }
}
