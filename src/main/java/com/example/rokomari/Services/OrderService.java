package com.example.rokomari.Services;

import com.example.rokomari.DTO.BookDto;
import com.example.rokomari.DTO.OrderDto;
import com.example.rokomari.DTO.UserDto;
import com.example.rokomari.Entities.Book;
import com.example.rokomari.Entities.Order;
import com.example.rokomari.Entities.User;
import com.example.rokomari.Repository.BookRepo;
import com.example.rokomari.Repository.OrderRepo;
import com.example.rokomari.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
//   @Autowired
//    BookRepo bookRepo;
//   @Autowired
//    OrderRepo orderRepo;
   @Autowired
    UserRepo userRepo;

   public UserDto userOrderDetails(Long userId){
       Optional<User> optionalEmployeeEntity = userRepo.findById(userId);
       User user = optionalEmployeeEntity.get();
       if(user==null){
           throw new RuntimeException("User not found");
       }
       return mapUserDto(user);
   }

    public UserDto mapUserDto(User user){
        List<OrderDto> orderDtoList = new ArrayList<OrderDto>();
        for(Order order : user.getOrderList()){
            orderDtoList.add(mapOderDto(order));
        }
        UserDto userDto = new UserDto(user.getUsername(),user.getGender(),user.getMobileNumber(),user.getOrderList().size(),orderDtoList);
        return userDto;

    }
    public BookDto mapBookDto(Book book){
        BookDto bookDto = new BookDto(book.getTitle(),book.getPrice(),book.getDiscount());
        return bookDto;

    }
    public OrderDto mapOderDto(Order order){
        List<BookDto> bookDtoList = new ArrayList<BookDto>();
       for(Book book : order.getBooks()){
          bookDtoList.add(mapBookDto(book));
       }
        OrderDto orderDto = new OrderDto(order.getOrderId(),order.getOrderDate(),order.getBooks().size(),bookDtoList);
        return orderDto;
    }

}
