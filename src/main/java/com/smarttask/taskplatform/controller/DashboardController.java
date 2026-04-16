package com.smarttask.taskplatform.controller;


import com.smarttask.taskplatform.dto.DashBoardDto;
import com.smarttask.taskplatform.response.SuccessResponse;
import com.smarttask.taskplatform.service.DashBoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DashboardController {

    private final DashBoardService service;

    public DashboardController(DashBoardService service) {
        this.service = service;
    }

    // GET /api/dashboard
    @GetMapping("/dashboard")
    public ResponseEntity<SuccessResponse<DashBoardDto>> getDashboard() {

        return ResponseEntity.ok(
                new SuccessResponse<>("Dashboard fetched",
                        service.getDashboard())
        );
    }
}