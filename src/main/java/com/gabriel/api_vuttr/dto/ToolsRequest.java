package com.gabriel.api_vuttr.dto;

import com.gabriel.api_vuttr.entities.Tools;

import java.util.List;

public record ToolsRequest(String title, String link, String description, List<String> tags){
    public Tools toModel(){
        return new Tools(title,link,description,tags);
    }
}

