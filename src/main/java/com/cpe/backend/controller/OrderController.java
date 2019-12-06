package com.cpe.backend.controller;

import com.cpe.backend.entity.Rider;
import com.cpe.backend.repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cpe.backend.entity.Order;
import com.cpe.backend.repository.OrderRepository;

@CrossOrigin(origins = CORS.avaliable)
@RestController
public class OrderController {

    @Autowired
    private final OrderRepository OrderRepository;
    private  final RiderRepository riderRepository;

    public OrderController(OrderRepository OrderRepository, RiderRepository riderRepository) {
        this.OrderRepository = OrderRepository;
        this.riderRepository = riderRepository;
    }

    @GetMapping("/Order")
    public Collection<Order> Orders() {
        return OrderRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/FindOrdersByStatus")
    public Collection<Order> FindOrdersByStatus() { return OrderRepository.findOrdersByOrderStatus(); }

    @GetMapping("/Order/{id}")
    public Optional<Order> Orders(@PathVariable Long id) {
        Optional<Order> Order = OrderRepository.findById(id);
        return Order;
    }

    @GetMapping("/FindOrdersByRiderId/{rid}")
    public Collection<Order> FindOrdersByRiderId(@PathVariable String rid) { return OrderRepository.findOrdersByRiderId(rid); }

    @PutMapping("/Order/{id}/{status}")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable(value = "id") Long id, @PathVariable(value = "status") String status) throws ResourceNotFoundException {
        Order order1 = OrderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + id));
        order1.setStatus(status);
        final Order updatedOderStatus = OrderRepository.save(order1);
        return ResponseEntity.ok(updatedOderStatus);
    }

    @PutMapping("/ReceiveOrderTimeStamp/{id}")
    public ResponseEntity<Order> receiveOrderTimeStamp(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Order order1 = OrderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + id));
        Date date = new Date();
        order1.setReceivedDate(date);
        final Order receiveOrderTimeStamp = OrderRepository.save(order1);
        return ResponseEntity.ok(receiveOrderTimeStamp);
    }

    @PutMapping("/DeliveredOrderTimeStamp/{id}")
    public ResponseEntity<Order> deliveredOrderTimeStamp(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Order order1 = OrderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + id));
        Date date = new Date();
        order1.setDeliveredDate(date);
        final Order deliveredOrderTimeStamp = OrderRepository.save(order1);
        return ResponseEntity.ok(deliveredOrderTimeStamp);
    }

    @PutMapping("/updateRiderIdOnOrder/{id}")
    public ResponseEntity<Order> updateRiderIdOnOrder(@PathVariable(value = "id") Long id, @RequestBody Rider rider) throws ResourceNotFoundException {
        Order order1 = OrderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + id));
        order1.setRider(rider);
        final Order updatedOderStatus = OrderRepository.save(order1);
        return ResponseEntity.ok(updatedOderStatus);
    }

    @DeleteMapping("/clearRiderIdOnOrder/{id}")
    public ResponseEntity<Order> clearRiderIdOnOrder(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Order order1 = OrderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + id));
        Rider r = new Rider();
        r.setId("0000");
        r.setPassword("");
        r.setIncome(0);
        r.setUsername("");
        r.setName("");
        order1.setRider(r);
        final Order updatedOderStatus = OrderRepository.save(order1);
        return ResponseEntity.ok(updatedOderStatus);
    }
}