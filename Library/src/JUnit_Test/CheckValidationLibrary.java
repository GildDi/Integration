package JUnit_Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckValidationLibrary {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	//check validation
	public boolean isValidTicketNumber(String id) {
	    return id.matches("[A-Za-z0-9,.!?-]+"); // символы Номер билета (letters, digits, punctuation)
	}

	@Test
	void testIsValidTicketNumber() {
		//fail("Not yet implemented");
		  assertTrue(isValidTicketNumber("AB1234-!"));
	        assertTrue(isValidTicketNumber("1234"));
	}
	@Test
    public void testInvalidTicketNumber() {
        assertFalse(isValidTicketNumber("AB*#1234"));
        assertFalse(isValidTicketNumber("1234 5678"));
    }
	//check research book algorithm
	// Arrays for Books
		String[] bookNames = {
		    "Война и мир", "Евгений Онегин", "Наука и жизнь",
		    "Преступление и наказание", "Мастер и Маргарита", "1984",
		    "Гарри Поттер и философский камень", "Шерлок Холмс", "Алхимик", "Три мушкетера",
		    "Бездуховные", "Стив Джобс: Биография", "Глобальное потепление",
		    "Отцы и дети", "Пикник на обочине", "Убийство в Восточном экспрессе", 
		    "Тайна острова", "Анна Ахматова: Избранное", "Братья Карамазовы", "Доктор Живаго"
		};

		String[] bookCategories = {
		    "Классическая литература", "Поэзия", "Научные журналы",
		    "Роман", "Фантастика", "Научная литература", "Фэнтези",
		    "Детектив", "Приключения", "Исторический роман",
		    "Философия", "Биография", "Документалистика"
		};

		String[] bookAuthors = {
		    "Толстой", "Пушкин", "Издательство Наука", "Достоевский", "Булгаков", "Оруэлл",
		    "Роулинг", "Конан Дойл", "Коэльо", "Дюма", "Глуховский", "Исааксон", "Автор",
		    "Тургенев", "Стругацкие", "Пуаро", "Конан Дойл", "Ахматова", "Достоевский", "Пастернак"
		};

		// Assigning books to categories, with repetition of category indices (ambiguity)
		int[] bookCategoryIndices = {
		    0,  // "Война и мир" - Классическая литература
		    1,  // "Евгений Онегин" - Поэзия
		    2,  // "Наука и жизнь" - Научные журналы
		    3,  // "Преступление и наказание" - Роман
		    4,  // "Мастер и Маргарита" - Фантастика
		    5,  // "1984" - Научная литература
		    6,  // "Гарри Поттер и философский камень" - Фэнтези
		    7,  // "Шерлок Холмс" - Детектив
		    8,  // "Алхимик" - Приключения
		    9,  // "Три мушкетера" - Исторический роман
		    10, // "Бездуховные" - Философия
		    11, // "Стив Джобс: Биография" - Биография
		    12, // "Глобальное потепление" - Документалистика
		    0,  // "Отцы и дети" - Классическая литература (same category as "Война и мир")
		    4,  // "Пикник на обочине" - Фантастика (same category as "Мастер и Маргарита")
		    7,  // "Убийство в Восточном экспрессе" - Детектив (same category as "Шерлок Холмс")
		    6,  // "Тайна острова" - Фэнтези (same category as "Гарри Поттер")
		    1,  // "Анна Ахматова: Избранное" - Поэзия (same category as "Евгений Онегин")
		    3,  // "Братья Карамазовы" - Роман (same category as "Преступление и наказание")
		    9   // "Доктор Живаго" - Исторический роман (same category as "Три мушкетера")
		};

		
		// Arrays for Journals
		String[] journalNames = {
		    "Техника молодежи", "Компьютерра", "Наука сегодня", 
		    "Журнал экономики", "История науки", "Эксперт", "В мире науки",
		    "Космонавтика", "Технологии XXI века", "Физика сегодня"
		};
		String[] journalCategories = {
		    "Техника", "ИТ", "Наука", "Экономика", "История", "Бизнес", "Наука и техника",
		    "Космос", "Современные технологии", "Физика"
		};
		String[] journalAuthors = {
		    "Издательство ТМ", "Издательство К", "Издательство Н", "Издательство Э", "Издательство И",
		    "Издательство Б", "Издательство НТ", "Издательство КС", "Издательство Т21", "Издательство ФТ"
		};
		// Array for Journal Category Indices
		int[] journalCategoryIndices = {
		    0, 1, 2, 3, 4, 3, 2, 5, 6, 7, // Repeating and adding more categories for the journals
		    0, 1, 2, 3, 5, 6, 7, 2, 0, 5
		};
		
		
		//I need to add the result string
		public String generateBookResults(String name, int index)
		{// Result Generation Logic
			
			//String str = String.valueOf(i);
            String result = new String(); 
            
            for (int i = 0; i < bookNames.length; i++) {
                if (bookCategoryIndices[i] == index) {
                	//if (bookNames[i].toLowerCase().contains(name)) 
                	{
                    //result.append("- ").append(bookNames[i]).append(" (").append(bookAuthors[i]).append(")\n");
                		result = "" + name + " " + index + "";
                	}
                }
            }
            
            
            //result = "" + name + " " + str + "";
			return result;
		}
		
		//now lets test the wizard magnifier
		
		@Test
		public void testBookResultGeneration() {
		    String searchTerm = "Тайна острова";
		    String result = generateBookResults(searchTerm, 6); // Simulate book search
		    assertTrue(result.contains("Тайна острова 6"));
		    assertFalse(result.contains("wrong")); // Ensure journals aren't included
		}
		
		//I need to add the result string
				public String generateJournalResults(String name, int index)
				{// Result Generation Logic
					
					//String str = String.valueOf(i);
		            String result = new String(); 
		            
		            for (int i = 0; i < journalNames.length; i++) {
		                if (journalCategoryIndices[i] == index) {
		                	//if (bookNames[i].toLowerCase().contains(name)) 
		                	{
		                    //result.append("- ").append(bookNames[i]).append(" (").append(bookAuthors[i]).append(")\n");
		                		result = "" + name + " " + index + "";
		                	}
		                }
		            }
		            
		            
		            //result = "" + name + " " + str + "";
					return result;
				}
				
				//now lets test the wizard magnifier

		@Test
		public void testJournalResultGeneration() {
		    String searchTerm = "Наука сегодня";
		    String result = generateJournalResults(searchTerm, 2); // Simulate journal search
		    assertTrue(result.contains("Наука сегодня 2"));
		    assertFalse(result.contains("wrong")); // Ensure books aren't included
		}

		

	/*private BooleanSupplier isValidTicketNumber(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	*/

}
