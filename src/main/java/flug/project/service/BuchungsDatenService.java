package flug.project.service;

import flug.project.entity.BuchungsDaten;

import java.util.List;

public interface BuchungsDatenService extends MainServiceInterface<BuchungsDaten, Integer, Integer> {

    BuchungsDaten create(BuchungsDaten buchungsDaten, Integer passId, Integer flugId);

    List<BuchungsDaten> get(Integer nummer, String flugId);
}
