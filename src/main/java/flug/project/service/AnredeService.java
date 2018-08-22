package flug.project.service;

import flug.project.entity.Anrede;
import flug.project.service.interfaces.InterfaceWithMap;

import java.util.Map;

public interface AnredeService extends InterfaceWithMap<Anrede, String, Integer> {

    Anrede create(Anrede anrede);
}
