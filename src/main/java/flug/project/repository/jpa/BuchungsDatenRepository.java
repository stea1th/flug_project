package flug.project.repository.jpa;

import flug.project.entity.BuchungsDaten;
import flug.project.repository.MainRepositoryInterface;

import java.util.List;

public interface BuchungsDatenRepository extends MainRepositoryInterface<BuchungsDaten, Integer, Integer> {
    List<BuchungsDaten> getBuchungsDaten(Integer nummer, String flugId);
}
