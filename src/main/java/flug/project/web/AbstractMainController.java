package flug.project.web;

import flug.project.service.*;
import flug.project.utils.ConverterUtil;
import flug.project.xlsreader.XLSReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;


public abstract class AbstractMainController {

    @Autowired
    private LandService landService;

    @Autowired
    private OrtService ortService;

    @Autowired
    private AdresseService adresseService;

    @Autowired
    private AnredeService anredeService;

    @Autowired
    private PassagierService passagierService;

    @Autowired
    private FlughafenService flughafenService;

    @Autowired
    private FluggeselschaftService fluggeselschaftService;

    @Autowired
    private LinieService linieService;

    @Autowired
    private FlugzeugTypService flugzeugTypService;

    @Autowired
    private FlugService flugService;

    @Autowired
    private BuchungsDatenService buchungsDatenService;

    void saveAll(String url) throws IOException {

        int count = 0;
        for(String[] arr : XLSReader.readXLS(ConverterUtil.convertToUrl(url))){
            String landId = landService.saveIt(arr[24]);
            String ortId = ortService.saveIt(arr[22], landId);
            int adrId = adresseService.saveIt(ortId, arr[21], arr[23]);
            String anrId = anredeService.saveIt(arr[19]);
            int passId = passagierService.saveIt(new Integer[]{adrId}, anrId, arr[18], arr[20]);

            String vonFlug = flughafenService.saveIt(arr[3], ortService.saveIt(arr[5], landService.saveIt(arr[4])));
            String bisFlug = flughafenService.saveIt(arr[6], ortService.saveIt(arr[8], landService.saveIt(arr[7])));

            String fluggesId = fluggeselschaftService.saveIt(arr[0], arr[1]);

            int linId = linieService.saveIt(arr[2], arr[9], vonFlug, bisFlug, fluggesId);
            int ftId = flugzeugTypService.saveIt(arr[12], arr[15], arr[13]);
            int flId = flugService.saveIt(new Integer[]{ftId, linId}, arr[10], arr[11], arr[14]);
            buchungsDatenService.saveIt(new Integer[]{passId, flId}, arr[0], arr[16], arr[17]);
            count++;
        }
        System.out.println("Line saved: "+count);
    }
}
