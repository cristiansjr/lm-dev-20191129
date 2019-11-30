<template>
  <div id="container">
    <form>
      <div class="row">
        <div
          class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3"
        >
          <h2>Ingresa el producto</h2>
          <div class="form-group">
            <label for="productTitle">Titulo del producto</label>
            <input
              type="text"
              id="productTile"
              class="form-control"
              v-model.lazy="product.title"
            />
          </div>
          <br />
          <div class="form-group">
            <label for="productDescription">Descripcion del producto</label>
            <textarea
              type="text"
              id="productDescription"
              class="form-control"
              v-model.lazy="product.description"
            />
          </div>
          <div class="form-group">
            <label for="productPrice">Precio del producto</label>
            <input
              type="text"
              id="productPrice"
              class="form-control"
              v-model.lazy="product.price"
            />
            {{ validateNumber(product.price) }}
          </div>
          <div class="form-group">
            <label for="productImageUrl">URL de la imagen del producto</label>
            <input
              type="text"
              id="productImageUrl"
              class="form-control"
              v-model.lazy="product.imageUrl"
            />
          </div>
        </div>
      </div>
      <hr />
      <div class="row">
        <div
          class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3"
        >
          <button class="btn btn-primary" @click.prevent="submitted">
            Agregar
          </button>
        </div>
      </div>
    </form>
    <div class="row" v-if="isSubmitted">
      <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
        <div class="panel panel-default">
          <div class="panel-heading">
            <h4>Resumen del producto:</h4>
          </div>
          <div class="panel-body">
            <p>Titulo: {{ product.title }}</p>
            <p>Descripcion: {{ product.description }}</p>
            <p>precio: {{ product.price }}</p>
            <p>URL imagen: {{ product.imageUrl }}</p>
          </div>
          {{ messageResult }}
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  //name: "app",
  data() {
    return {
      company: "TestCo",
      currency: "USD",
      product: {
        title: "",
        description: "",
        price: 1.1,
        imageUrl: ""
      },
      isSubmitted: false,
      messageResult: ""
    };
  },
  methods: {
    validateNumber(valor) {
      if (isNaN(valor) != false) return "Invalid price";
    },
    submitted() {
      this.isSubmitted = true;
      this.$http
        .post(
          "https://private-b83e1-cristianjuarez.apiary-mock.com/product/country",
          this.product
        )
        .then(result => {
          console.log(result);
          this.messageResult = result.body.message;
        })
        .catch(err => {
          console.log(err);
        });
    }
  }
};
</script>

<style lang="scss"></style>
