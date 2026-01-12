### 🧩 Problem Statement:

Your company manages a burger inventory system. Multiple modules (e.g., Website, Mobile App, Admin Dashboard) need to be notified **immediately and independently** whenever the stock of burgers changes.

You are required to implement a solution that:

- Avoids tight coupling between the inventory system and the modules.
- Allows modules to dynamically register/unregister for notifications.
- Cleanly separates the **subject (BurgerStock)** from its **observers (UI components, services)**.