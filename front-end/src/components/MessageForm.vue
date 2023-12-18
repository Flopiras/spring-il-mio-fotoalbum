<script>
import axios from 'axios';

const endpoint = "http://localhost:8080/api/messages";

export default {
    data() {
        return {
            message: {
                title: "",
                content: ""
            }
        }
    },

    methods: {
        async sendMessage() {

            await axios.post(endpoint, this.message);
            // Pulisci i campi del modulo dopo l'invio
            this.message.title = "";
            this.message.content = "";
        }
    }
}

</script>

<template>
    <div class="my-4">
        <h2 class="text-center">Scrivi un messaggio all'autore</h2>

        <form @submit.prevent="sendMessage">

            <!--title-->
            <div class="mb-3">
                <label for="title" class="form-label">Titolo del messaggio</label>
                <input v-model="message.title" type="text" class="form-control" id="title" name="title">
            </div>

            <!--content-->
            <div class="mb-3">
                <label for="content" class="form-label">Contenuto del messaggio</label>
                <textarea v-model="message.content" class="form-control" id="content" name="content" rows="4"></textarea>
            </div>

            <!-- button -->
            <div class="d-flex justify-content-center mt-4">
                <button class="btn btn-success">Invia</button>
            </div>
        </form>
    </div>
</template>