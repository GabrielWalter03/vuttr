package com.gabriel.api_vuttr.services;

import com.gabriel.api_vuttr.dto.ToolsResponse;
import com.gabriel.api_vuttr.entities.Tools;
import com.gabriel.api_vuttr.repository.ToolsRepository;
import org.springframework.stereotype.Service;

import javax.tools.Tool;
import java.util.List;

@Service
public class ToolsService {

    private final ToolsRepository toolsRepository;

    public ToolsService(ToolsRepository toolsRepository){
        this.toolsRepository = toolsRepository;
    }

    public List<Tools> getAllTools(){
        List<Tools> toolsList = toolsRepository.findAll();
        return toolsList;
    }

    public List<Tools> findToolByTag(String tags){
        List<Tools> toolsList = toolsRepository.buscar(tags);
        return toolsList;
    }

    public ToolsResponse saveTools(Tools tools){

        Tools toolsSaved = toolsRepository.save(tools);

        ToolsResponse toolsResponse= new ToolsResponse(tools.getId(),
                toolsSaved.getTitle(),
                toolsSaved.getLink(),
                toolsSaved.getDescription(),
                toolsSaved.getTags());

        return  toolsResponse;
    }

    public void deleteToolsById(Long id){
        toolsRepository.deleteById(id);
    }
}
