package polyglot.ms.test.transaction.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import polyglot.ms.test.transaction.model.TransactionModel;

@Repository
public interface ITransactionRepository extends MongoRepository<TransactionModel, String> {

	@Query("{'id_invoice':?0}")
	public Iterable<TransactionModel> findByIdInvoice(Integer id_invoice);

	@Query("{'id_transaction':?0}")
	public TransactionModel findByIdTransaction(Integer id_transaction);

	@Query(value = "{ 'id_transaction': ?0 }", delete = true)
	public void deleteByIdTransaction(Integer id_transaction);

	// OPTIONS QUERY
	// $options: "i" → insensible a mayúsculas/minúsculas.
	// $regex: "pago" → busca coincidencias parciales dentro de description.
	// $regex: "^texto" - Coincide al inicio del campo
	// $regex: "texto$" - Coincide al final del campo

	// Inicio: LIKE 'texto%'
	// @Query("{ 'description': { $regex: '^?0', $options: 'i' } }")

	// Fin: LIKE '%texto'
	// @Query("{ 'description': { $regex: '?0$', $options: 'i' } }")

	// Oprional repository search:
	// List<TransactionModel> resultados =
	// transactionRepository.findByDescriptionRegex("pago"); - > "%busqueda%"

	@Query("{ 'NOMBRECOLUMNAMONGODB': { $regex: ?0, $options: 'i' } }")
	List<TransactionModel> findByDescriptionRegex(String regex);

	// AND
	@Query("{ 'id_invoice': ?0, 'amount': { $gt: ?1 } }")
	List<TransactionModel> findExpensiveTransactions(Integer id_invoice, double minAmount);

	// OR
	@Query("{ $or: [ { 'id_invoice': ?0 }, { 'id_transaction': ?1 } ] }")
	List<TransactionModel> findByInvoiceOrTransaction(Integer id_invoice, Integer id_transaction);

	List<TransactionModel> findByAmountBetween(double min, double max);

	public class ValueResult {
		private double value;

		public double getValue() {
			return value;
		}

		public void setValue(double value) {
			this.value = value;
		}
	}

	// SUMA
	@Aggregation(pipeline = {
			"{ $group: { _id: null, value: { $sum: '$amount' } } }"
	})
	ValueResult getTotalAmount();

	// MÁXIMO
	@Aggregation(pipeline = {
			"{ $group: { _id: null, value: { $max: '$amount' } } }"
	})
	ValueResult getMaxAmount();

	// MÍNIMO
	@Aggregation(pipeline = {
			"{ $group: { _id: null, value: { $min: '$amount' } } }"
	})
	
	ValueResult getMinAmount();

	// 4️⃣ Resumen con suma, máximo y mínimo usando @Aggregation
	@Aggregation(pipeline = {
			"{ $group: { _id: null, totalAmount: { $sum: '$amount' }, maxAmount: { $max: '$amount' }, minAmount: { $min: '$amount' } } }"
	})
	SummaryResult getAmountSummary();

	// Clase interna para mapear resultados de la agregación
	class SummaryResult {
		private double totalAmount;
		private double maxAmount;
		private double minAmount;

		public double getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}

		public double getMaxAmount() {
			return maxAmount;
		}

		public void setMaxAmount(double maxAmount) {
			this.maxAmount = maxAmount;
		}

		public double getMinAmount() {
			return minAmount;
		}

		public void setMinAmount(double minAmount) {
			this.minAmount = minAmount;
		}
	}

}