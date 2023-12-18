<script>
export default {
    props: {
        photo: Object
    }
}
</script>

<template>
    <h1 class="text-center mt-4">{{ photo.title }}</h1>

    <!-- image -->
    <div class="d-flex justify-content-center mb-4">
        <img :src="photo.url" :alt="photo.title" class="img-fluid">
    </div>

    <!-- description -->
    <div class="d-flex align-items-center flex-column">
        <h5>Descrizione</h5>
        <p>{{ photo.description }}</p>
    </div>
</template>