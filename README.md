# Survencee 🗞️📊

**Survencee** is a modern, AI-enhanced backend platform designed using **Spring Boot**. It enables verified **survey creators** to publish their research with proof, and allows authenticated **reporters** to generate meaningful reports using **Google's Gemini API**. This backend system is engineered for scalability, modularity, and real-world production use cases — integrating secure authentication, file handling, message queues, caching, and NoSQL data storage.

---

## 🚀 Core Features

- 🧾 **Survey Submission with Proofs**  
  Users can upload **multiple verification files** (images, PDFs, etc.) with each survey.

- 👤 **Profile Picture Uploads**  
  File upload support for user avatars during profile setup.

- 🔐 **Robust JWT-Based Authentication**
  - Built on **Spring Security 6**
  - Role-based access control (Survey Submitters / Reporters)
  - JWT login & secure logout
  - **Reporters** must register with a unique `channelName` field

- 🧠 **AI Report Generation (Gemini API)**  
  Reporters can generate intelligent summaries and insights from surveys using **Google Gemini API** integration.

- 🧵 **Apache Kafka Messaging Queue**
  - Publishes events on new survey submissions to a Kafka topic
  - Enables future integration with analytics, moderation, email triggers

- ⚡ **Redis Caching**
  - Caches frequently accessed surveys and session data
  - Greatly improves performance & reduces DB hits

- 🍃 **MongoDB as Primary Database**
  - Schemaless document structure ideal for survey content
  - Fast querying, scalable for high-volume data

- ✨ **Lombok Integration**
  - Clean code with reduced boilerplate via annotations like `@Getter`, `@Setter`, `@Builder`, etc.

---

## 🧑‍💻 Tech Stack

| Layer        | Technology                           |
|--------------|---------------------------------------|
| Backend      | Spring Boot                           |
| Security     | Spring Security 6 + JWT               |
| Database     | MongoDB                               |
| Messaging    | Apache Kafka                          |
| Caching      | Redis                                 |
| AI API       | Google Gemini                         |
| ORM/Mapper   | Spring Data MongoDB                   |
| Boilerplate  | Lombok                                |
| Build Tool   | Maven                                 |
| File Uploads | MultipartResolver (local/cloud-ready) |

---

## 📁 Key API Endpoints

| Method | Endpoint                | Description                         |
|--------|-------------------------|-------------------------------------|
| POST   | `/api/auth/signup`      | Register as reporter or survey user |
| POST   | `/api/auth/login`       | Login & receive JWT                 |
| POST   | `/api/auth/logout`      | Secure logout                       |
| POST   | `/api/surveys`          | Submit new survey with proofs       |
| GET    | `/api/surveys`          | View all posted surveys             |
| POST   | `/api/report/generate`  | Generate report from survey data    |
| POST   | `/api/upload/profile`   | Upload profile picture              |

---

## 🧠 Gemini AI Integration

- Auto-generates summaries and reports
- Accepts JSON-formatted survey input
- Ideal for journalists creating quick editorial content

---

## ⚙️ Kafka Integration

- Publishes events on survey creation
- Scalable for future async processing:
  - Email notifications
  - Moderation pipelines
  - Admin alerts

---

## ⚡ Redis Caching

- Stores hot data like:
  - Frequently viewed surveys
  - Recently active users
- Speeds up GET operations
- Reduces MongoDB load under scale

---

## 🍃 MongoDB Schema Sample

```json
{
  "_id": "uuid",
  "title": "Survey on Water Quality",
  "description": "Collected data from 5 local regions...",
  "submittedBy": "userId",
  "proofs": ["file1.jpg", "file2.pdf"],
  "createdAt": "2024-05-01T12:00:00Z"
}
