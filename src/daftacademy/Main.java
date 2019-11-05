package daftacademy;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*
        Ship ship = Parser.parseShip("15: Ning-Po (Feedermax)");
        Container container = Parser.parseContainer("BE-BR-61613986/3551/B1@oqk.bf/39927");
        System.out.println(ship);
        System.out.println(container + "\n");
         */
        /*
        String[] parts;
        String shipsString = "1: Brandenburg (Post-Panamax);2: Acheron (Feeder);3: Blue (New Panamax);4: Charlotte (Panamax);5: Fenton (Feedermax);6: Hawksub (Feedermax);7: Erebus (Small feeder);8: Aeolus (ULCV);9: Nellie (Small feeder);10: Pharaoh (Small feeder);11: Alexandria (Feedermax);12: Bebop (Panamax);13: Albatross (Small feeder);14: Argonautica (Post-Panamax);15: Ning-Po (Feedermax);16: Amindra (Post-Panamax);17: Mortzestus (Small feeder);18: Orca (Feeder);19: Grayfish (Feeder);20: Shark (New Panamax);21: Nerka (ULCV);22: Demeter (Post-Panamax);23: Santana (New Panamax);24: Misery (Feeder);25: Pequod (Feeder);26: Cithara (Small feeder);27: Liparus (Feeder);28: Illustria (Feeder);29: Gotha (Feeder);30: Duncan (Feedermax);31: Baalbek (ULCV);32: Gerrymander (Panamax);33: Jeroboam (ULCV);34: Skyline (ULCV);35: Belafonte (Feedermax);36: Argo (Feeder);37: Genesis (New Panamax);38: Neptune (Panamax);39: Tsimtsum (Feeder);40: Wolfgang (Small feeder);41: Dazzler (Feeder);42: Turtle (Panamax);43: Sirius (ULCV);44: Vulkan (Post-Panamax);45: Chelsea (New Panamax);46: Corsair (Panamax);47: Literature (Post-Panamax);48: Arcadia (Feedermax);49: Siren (ULCV);50: Saracen (Small feeder);51: Milka (ULCV);52: Ulysses (Small feeder);53: Patna (Panamax);54: Queequeg (Feeder);55: Wonkatania (New Panamax);56: Starfish (Small feeder);57: Karaboudjan (Post-Panamax);58: Unicorn (Feeder);59: Poseidon (Small feeder)";
        parts = Parser.split(shipsString);
        List<Ship> ships = Parser.parseShips(parts);
        System.out.println(ships.size());
        for (Ship sh : ships)
            System.out.println(sh);

        System.out.println();

        //String containersString = "ES-NL-10633096/1938/X1@hkzydbezon.dk/6749;DE-JP-20438082/2066/A2@qwinfhcaer.cu/68849;PA-AE-63285771/2999/A1@iolgtrzho.cz/76988;VN-KP-26996852/1652/Y1@plxem.cu/25644;BE-DE-90904024/1798/B3@hkzydbezon.dk/5066;JP-SG-38622271/4658/B3@zwyabd.sm/73934;MT-OM-16480323/3443/Y2@dnmscilcq.mt/25213;US-MY-37516883/5355/B1@mvvi.sb/95670;GR-PA-73242022/2702/X2@vqzmxsw.pl/96178;SA-MT-42024041/4612/Z1@ilipnwqnn.cl/59107;MT-ID-97970901/6092/Y1@mmsvwytaal.ps/26959;VN-PH-63895888/5637/C3@bhvxkwvfn.bi/98262;GR-US-95413570/1398/C1@udbnbrgquf.de/48565;AE-KP-66722662/3973/Z1@wgrvgvk.gs/86964;BR-IN-60618782/2716/Y2@qsofall.yt/89290;US-GB-36469456/2616/C1@hvdmy.ge/38178;GR-TH-10557254/4693/Y1@uolv.cl/6358;LK-NL-41976534/6255/C1@gkz.br/78675;GB-MA-82024654/4325/A1@zhicvzvksl.cl/73081;CA-BE-65377452/5398/X1@nsjeuhbe.na/54333;SA-TH-98644967/4567/Z1@qfmgev.nl/60416;SG-MY-71077682/3592/A2@tgmyhcsuj.dk/34926;TW-MA-03256585/1691/C2@ypkxinu.gm/2751;TH-MT-54316182/5918/B3@lch.br/85351;ID-MA-09730626/5168/Y1@bcxdza.by/76086;IN-SA-34299015/4394/A2@ofvyvmc.gq/44819;SG-BE-64071438/4990/Y2@tuvjmrxve.cz/4018;MY-ES-57022580/2716/X2@gltmtnrpg.by/56542;MA-AE-99520660/3822/B2@dkjnboa.sb/16834;DE-BR-20229369/5215/Y2@zxmedwrq.bi/66224;VN-ES-12261553/4700/B3@ofl.hr/92193;PA-ID-19918631/1234/B3@ydfissit.sy/93892;AE-TH-72679349/2264/C2@ffojngwnk.tf/99155;CA-MA-75200812/4894/Y2@vyvuozc.is/81867;JP-MA-20775213/4066/Y2@jfwqkwysk.by/11082;PH-MT-55113134/1466/X1@seyvt.tk/89569;LK-MY-31043710/2179/A3@eemfu.sm/14259;BE-TH-38565222/3007/B3@fflo.mp/85758;US-PA-80163944/1214/A3@behvjb.mp/65065;MY-ID-55445272/5571/Y1@drlcilkbnu.ru/72231;MA-OM-40323520/2101/B2@ecwnzrzsg.se/7554;KP-CA-85581785/5382/A1@pblts.ne/94596;TW-TW-61746785/6257/C3@iwkpkujibx.is/31003;BE-MA-26435943/5006/C2@dgbukh.sh/90244;GB-GB-75058495/6085/B2@qnizvy.hr/35368;LK-TH-92232419/3705/B2@gaoexsonfk.by/19710;DE-NL-49162833/4806/Y1@unthw.ba/65963;MA-IN-27096577/4686/B2@hwocyj.ua/36747;VN-AE-63880300/2272/Y2@nmye.gs/77003;PA-PA-62071864/1867/C1@puhdx.af/21207;US-SA-62558339/4531/B2@mrqlnj.sy/88474;US-OM-76239717/2420/B3@qczkrqiad.by/29539;GR-ID-84131527/4192/B2@gjmibj.nz/81242;BR-TW-46083641/6061/B1@iqpde.by/34774;US-MT-92112942/1782/C3@kktaofq.gm/2923;ID-SA-92520600/4080/Y1@pbur.cl/97262;TH-ES-50758138/5800/A1@wybayf.my/12181;MA-ES-93602809/5344/A3@oysni.ba/77317;US-CA-62053914/5112/C2@yjyo.gs/84741";
        String containersString = ";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;GB-OM-61012440/1660/X1@ebmwtbe.my/38191;;;;;;;;;;;;;;;;;;;;;;;;;;;;";
        parts = Parser.split(containersString);
        List<Container> containers = Parser.parseContainers(parts);
        System.out.println(parts.length + " " + containers.size());
        for (Container co : containers)
            System.out.println(co);
        */
        /*
        File file = new File("data/daftacademy/daneSmall.csv");
        List<Ship> ships = Parser.parseCSV(file);
        for(Ship ship : ships)
            System.out.println(ship);
        */
        File file = new File("data/daftacademy/dane.csv");
        List<Ship> ships = Parser.parseCSV(file);

        System.out.println("Total: " + Analyser.totalNumberOfContainers(ships));
        for(Ship ship : ships)
            System.out.println(ship + " containers: " + ship.numberOfContainers());


    }

}
