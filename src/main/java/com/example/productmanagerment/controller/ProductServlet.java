package com.example.productmanagerment.controller;

import com.example.productmanagerment.model.Product;
import com.example.productmanagerment.service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "productServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showcreateProduct(request, response);
                break;
            case "update":
                showupdateProduct(request, response);
                break;
            case "delete":
                showdeleteProduct(request, response);
                break;
            case "view":
                showviewProduct(request, response);
                break;
            default:
                showlistProduct(request, response);
                break;
        }
    }

    private void showdeleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product products = new ProductServiceImpl().delete(id);
        RequestDispatcher dispatcher;
        if (products == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("products", products);
            dispatcher = request.getRequestDispatcher("products/delete.jsp");
        }

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showviewProduct(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Product products = new ProductServiceImpl().findById(id);
        String name = request.getParameter("name");
        Product products = new ProductServiceImpl().findByName(name);
        RequestDispatcher dispatcher;
        if (products == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("products", products);
            dispatcher = request.getRequestDispatcher("products/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showupdateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product products = new ProductServiceImpl().findById(id);
        request.setAttribute("products", products);

        RequestDispatcher dispatcher;
        if (products == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("products/update.jsp");
        }

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showcreateProduct(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("products/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showlistProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = new ProductServiceImpl().findAll();
        request.setAttribute("products", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("products/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "update":
                updateProducct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                break;
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product products = new ProductServiceImpl().delete(id);
        RequestDispatcher dispatcher;
        if (products == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            new ProductServiceImpl().delete(id);
            try {
                response.sendRedirect("/products");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void updateProducct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String manufacturer = request.getParameter("manufacturer");
        double price = Double.parseDouble(request.getParameter("price"));

        Product products = new ProductServiceImpl().findById(id);
        RequestDispatcher dispatcher;

        if (products == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            products.setName(name);
            products.setDescription(description);
            products.setManufacturer(manufacturer);
            products.setPrice(price);
            new ProductServiceImpl().update(products, id);
            request.setAttribute("message", "Update product success");
            dispatcher = request.getRequestDispatcher("products/update.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String manufacturer = request.getParameter("manufacturer");
        double price = Double.parseDouble(request.getParameter("price"));
        int id = (int) (Math.random() * 1000000);

        Product product = new Product(id, name, price, description, manufacturer);
        new ProductServiceImpl().save(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("products/create.jsp");
        request.setAttribute("message", "Create product success");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
