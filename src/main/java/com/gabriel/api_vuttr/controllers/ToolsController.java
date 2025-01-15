package com.gabriel.api_vuttr.controllers;

import com.gabriel.api_vuttr.dto.ToolsRequest;
import com.gabriel.api_vuttr.dto.ToolsResponse;
import com.gabriel.api_vuttr.entities.Tools;
import com.gabriel.api_vuttr.services.ToolsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tools")
public class ToolsController {

    private ToolsService toolsService;

    public ToolsController(ToolsService toolsService){
        this.toolsService = toolsService;
    }

    @GetMapping
    public ResponseEntity findAll(){
        List<Tools> allTools = toolsService.getAllTools();

        return ResponseEntity.ok().body(allTools);
    }

    @GetMapping("/findByTag")
    public ResponseEntity findToolsByTag(@RequestParam String tags){
        List<Tools> toolsList = toolsService.findToolByTag(tags);


        return ResponseEntity.ok().body(toolsList);
    }

    @PostMapping
    public ResponseEntity saveTools(@RequestBody ToolsRequest toolsRequest){
        Tools toolsToBeSaved = toolsRequest.toModel();
        ToolsResponse toolsResponse = toolsService.saveTools(toolsToBeSaved);

        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(toolsResponse.id())
                .toUri();

        return ResponseEntity.created(headerLocation).body(toolsResponse);
    }

    @DeleteMapping
    public ResponseEntity deleteTools(@RequestParam Long id){
        toolsService.deleteToolsById(id);
        return ResponseEntity.ok().body("tool deleted");
    }

}
