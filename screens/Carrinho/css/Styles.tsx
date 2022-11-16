import { StyleSheet } from "react-native";

export const styles = StyleSheet.create({
  header: {
    flexDirection: "row",
    backgroundColor: "black",
    justifyContent: "space-between",
    alignItems: "center",
    flex: 2,
    padding: 10,
  },
  logo: {
    width: 50,
    height: 50,
    resizeMode: "cover",
  },
  titulo: {
    fontSize: 20,
    color: "white",
    fontweight: "bold",
  },
  btncarrinho: {
    padding: 20,
    backgroundColor: "#600",
    margin: 20,
    borderRadius: 50,
  },
  txtcarrinho: {
    color: "#fff",
    fontSize: 15,
    fontWeight: "bold",
    textAlign: "center",
  },

  produto: {
    padding: 10,
    fontSize: 15,
    fontWeight: "bold",
  },

  preco: {
    padding: 10,
    color: "#900",
    fontWeight: "bold",
    fontSize: 20,
  },

  quantidade: {
    fontSize: 15,
    color: "blue",
    padding: 10,
    fontWeight: "bold",
  },

  btnremovercarrinho: {
    backgroundColor: "red",
    width: 200,
    padding: 5,
    borderRadius: 10,
    marginRight: "auto",
    marginLeft: "auto",
  },

  fecharpedido: {},
});
