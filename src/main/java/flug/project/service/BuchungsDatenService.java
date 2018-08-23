package flug.project.service;

import flug.project.entity.BuchungsDaten;
import flug.project.service.interfaces.MainServiceInterface;

public interface BuchungsDatenService extends MainServiceInterface<BuchungsDaten, Integer, Integer> {

    BuchungsDaten create(BuchungsDaten buchungsDaten, Integer passId, Integer flugId);
}
