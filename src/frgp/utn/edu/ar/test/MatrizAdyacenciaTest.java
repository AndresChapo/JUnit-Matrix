package frgp.utn.edu.ar.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import frgp.utn.edu.ar.main.MatrizAdyacencia;

class MatrizAdyacenciaTest {
	
	private MatrizAdyacencia matriz = new MatrizAdyacencia(6);
	private int i=2;
	private int j=3;

	@AfterEach
	public void limpiarMatriz(){
		matriz.eliminarElemento(i,j);
		matriz.eliminarElemento(1,4);
		matriz.eliminarElemento(1,2);
	}
	
	@Test
	public void agregarElementoTest(){
		matriz.agregarElemento(i,j);		
		assertTrue(matriz.existeElemento(i,j));
	}
	
	@Test
	public void agregarElementoSimetriaTest(){
		matriz.agregarElemento(i,j);		
		assertTrue(matriz.existeElemento(j,i));
	}

	@Test
	public void eliminarElementoTest(){
		matriz.agregarElemento(i,j);
		matriz.eliminarElemento(i, j);		
		assertFalse(matriz.existeElemento(i,j));
	}
	
	@Test
	public void eliminarElementoSimetricoTest(){
		matriz.agregarElemento(i,j);
		matriz.eliminarElemento(i, j);
		assertFalse(matriz.existeElemento(j,i));
	}
	
	@Test
	public void contarRelacionesTest(){
		matriz.agregarElemento(2,3);
		matriz.agregarElemento(1,4);
		matriz.agregarElemento(1,2);
		assertEquals(3, matriz.getCantidadElementos());
	}
	
	@Test
	public void existenTodosLosElementoTest(){
		matriz.agregarElemento(2,3);
		matriz.agregarElemento(1,4);
		matriz.agregarElemento(1,2);
		assertTrue(matriz.existeElemento(2,3));
		assertTrue(matriz.existeElemento(3,2));
		assertTrue(matriz.existeElemento(1,4));
		assertTrue(matriz.existeElemento(4,1));
		assertTrue(matriz.existeElemento(1,2));
		assertTrue(matriz.existeElemento(2,1));
	}
}

