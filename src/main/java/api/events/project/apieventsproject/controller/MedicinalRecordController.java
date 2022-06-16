package api.events.project.apieventsproject.controller;

import api.events.project.apieventsproject.Exception.ResourceNotFoundException;
import api.events.project.apieventsproject.entity.MedicalRecord;
import api.events.project.apieventsproject.message.request.JsonResponse;
import api.events.project.apieventsproject.message.request.JsonResponseCreate;
import api.events.project.apieventsproject.repository.MedicalRecordRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "/api",description = "Medicinal")
@RequestMapping("/api")
public class MedicinalRecordController {

    MedicalRecordRepository recordRepository;

    @Autowired
    public MedicinalRecordController(MedicalRecordRepository recordRepository){
        this.recordRepository = recordRepository;
    }

    @ApiOperation(value="GET ALL Medicinal Records")
    @GetMapping("/medicinalRecord/all")
    public ResponseEntity<JsonResponse> getAllNotes() {
        List<MedicalRecord> medicalRecords = recordRepository.findAll();
        return new ResponseEntity<>(new JsonResponse(true,medicalRecords,"OK"), HttpStatus.OK);

    }


    @ApiOperation(value = "CREATE Medicinal Record")
    @PostMapping("/medicinalRecord/create")
    public ResponseEntity<JsonResponseCreate> create(@Validated @RequestBody MedicalRecord medicalRecord) {
         recordRepository.save(medicalRecord);
        return new ResponseEntity<>(new JsonResponseCreate(true,"create successfully","OK"), HttpStatus.OK);
    }


    @ApiOperation(value="GET SINGLE Medicinal Record")
    @GetMapping("/medicinalRecord/{id}")
    public MedicalRecord getEventById(@PathVariable(value = "id") Long event) {
        return recordRepository.findById(event)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", event));
    }

    @ApiOperation(value="EDIT Medicinal Record")
    @PutMapping("/medicinalRecord/update/{id}")
    public  ResponseEntity<JsonResponseCreate> UpdatedEvent(@PathVariable(value = "id") Long event, @RequestBody MedicalRecord medicalRecord) {
        MedicalRecord update = recordRepository.findById(event).orElseThrow(() -> new ResourceNotFoundException("Event:", "id", event));
        update.setName(medicalRecord.getName());
        update.setAddressCity(medicalRecord.getAddressCity());
        update.setAddressName(medicalRecord.getAddressName());
        update.setAddressNeighborhood(medicalRecord.getAddressNeighborhood());
        update.setAddressCountry(medicalRecord.getAddressCountry());
        update.setAddressNumber(medicalRecord.getAddressNumber());
        update.setAddressState(medicalRecord.getAddressState());
        update.setPostalCode(medicalRecord.getPostalCode());
        update.setAddressSupplement(medicalRecord.getAddressSupplement());
        update.setBirthdate(medicalRecord.getBirthdate());
        update.setAge(medicalRecord.getAge());
        update.setMotherName(medicalRecord.getMotherName());
        update.setComplaints(medicalRecord.getComplaints());
        update.setGender(medicalRecord.getGender());
        update.setCns(medicalRecord.getCns());
        update.setPhone(medicalRecord.getPhone());
        update.setPhoneSecondary(medicalRecord.getPhoneSecondary());
        update.setProfessional(medicalRecord.getProfessional());
        recordRepository.save(update);
        return new ResponseEntity<>(new JsonResponseCreate(true,"update successfully","OK"), HttpStatus.OK);
    }
    @ApiOperation(value = "DELETE Medicinal Record")
    @DeleteMapping("/medicinalRecord/delete/{id}")
    public ResponseEntity<?> DeleteEvent(@PathVariable(value = "id") Long id){
        MedicalRecord delete = recordRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Medicinal Record:", "id",id));
        recordRepository.delete(delete);

        return ResponseEntity.ok().build();
    }

}

