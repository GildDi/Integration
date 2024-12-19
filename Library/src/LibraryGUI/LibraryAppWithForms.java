package LibraryGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LibraryAppWithForms {

  
	
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


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new LibraryAppWithForms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
 // Function to check if the input contains only letters, digits, and punctuation
    public boolean isValidTicketNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!(Character.isLetterOrDigit(c) || isValidPunctuation(c))) {
                return false; // Invalid character found
            }
        }
        return true; // All characters are valid
    }

    // Function to check for valid punctuation marks (you can add more punctuation as needed)
    private boolean isValidPunctuation(char c) {
        String validPunctuation = ".,;!?-_()[]{}:\"'<>"; // You can customize this list
        return validPunctuation.indexOf(c) >= 0;
    }
    
    
    public LibraryAppWithForms() {
        JFrame frame = new JFrame("Библиотека");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(464, 328);

        // CardLayout and Panel Container
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // Input Form
        JPanel inputForm = new JPanel();
        inputForm.setBackground(Color.decode("#b8dbde"));
        inputForm.setLayout(null);

        JLabel nameLabel = new JLabel("Имя читателя:");
        nameLabel.setBounds(0, 2, 216, 43);
        nameLabel.setBackground(Color.decode("#E0E0E0"));
        JTextField nameField = new JTextField();
        nameField.setBounds(216, 2, 216, 43);
        nameField.setBackground(Color.decode("#E0E0E0"));
        JLabel idLabel = new JLabel("Номер читательского билета:");
        idLabel.setBounds(0, 45, 216, 43);
        JTextField idField = new JTextField();
        idField.setBounds(216, 45, 216, 43);
        idField.setBackground(Color.decode("#E0E0E0"));

        JLabel categoryLabel = new JLabel("Категория:");
        categoryLabel.setBounds(0, 143, 216, 43);
        JComboBox<String> categoryBox = new JComboBox<>(bookCategories); 
        categoryBox.setBounds(216, 143, 216, 43);
        categoryBox.setBackground(Color.decode("#80a8ab"));

        JButton submitButton = new JButton("Найти книгу или журнал");
        submitButton.setBounds(216, 238, 216, 43);
        submitButton.setBackground(Color.decode("#80a8ab"));

        // Search field for book/journal name
        JLabel searchLabel = new JLabel("Поиск по названию:");
        searchLabel.setBounds(0, 185, 216, 43);
        JTextField searchField = new JTextField();
        searchField.setBounds(216, 185, 216, 43);
        searchField.setBackground(Color.decode("#E0E0E0"));

        inputForm.add(nameLabel);
        inputForm.add(nameField);
        inputForm.add(idLabel);
        inputForm.add(idField);
        inputForm.add(categoryLabel);
        inputForm.add(categoryBox);
        inputForm.add(searchLabel);
        inputForm.add(searchField);
        inputForm.add(submitButton);

        // Result Form
        JPanel resultForm = new JPanel(new BorderLayout());
        resultForm.setBackground(Color.decode("#D8B7DD"));
        JTextArea resultArea = new JTextArea();
        resultArea.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
        resultArea.setBackground(Color.decode("#E0E0E0"));
        resultArea.setEditable(false);
        JScrollPane resultScroll = new JScrollPane(resultArea);
        resultForm.add(resultScroll, BorderLayout.CENTER);
        
        JButton backToInputFromResult = new JButton("Вернуться");
        backToInputFromResult.setFont(new Font("Segoe UI Variable Static Text Semibold", Font.PLAIN, 10));
        backToInputFromResult.setBackground(Color.decode("#80a8ab"));
        resultForm.add(backToInputFromResult, BorderLayout.SOUTH);

        // Error Form
        JPanel errorForm = new JPanel(new BorderLayout());
        errorForm.setBackground(Color.decode("#80a8ab"));
        JTextArea errorArea = new JTextArea();
        errorArea.setFont(new Font("DialogInput", Font.BOLD, 13));
        errorArea.setBackground(Color.decode("#E0E0E0"));
        errorArea.setEditable(false);
        JScrollPane errorScroll = new JScrollPane(errorArea);
        errorForm.add(errorScroll, BorderLayout.CENTER);

        JButton backToInputFromError = new JButton("Вернуться");
        backToInputFromError.setFont(new Font("Sitka Small", Font.BOLD, 10));
        backToInputFromError.setBackground(Color.decode("#80a8ab"));
        errorForm.add(backToInputFromError, BorderLayout.SOUTH);

        // Add panels to cardPanel
        cardPanel.add(inputForm, "input");
        cardPanel.add(resultForm, "result");
        cardPanel.add(errorForm, "error");

        // Initially show the input form
        cardLayout.show(cardPanel, "input");

        // Panel for Radio Buttons
        Panel panel = new Panel();
        panel.setBackground(Color.decode("#80a8ab"));
        panel.setBounds(0, 94, 432, 43);
        inputForm.add(panel);
        panel.setLayout(null);

        JRadioButton bookButton = new JRadioButton("Книга");
        bookButton.setBounds(6, 6, 207, 30);
        panel.add(bookButton);
        bookButton.setBackground(Color.decode("#a1d3d6"));
        bookButton.setSelected(true); // Default selection

        JRadioButton journalButton = new JRadioButton("Журнал");
        journalButton.setBounds(215, 6, 211, 30); 
        panel.add(journalButton);
        journalButton.setBackground(Color.decode("#a1d3d6"));
        
        ButtonGroup typeGroup = new ButtonGroup();       
        typeGroup.add(bookButton);
        typeGroup.add(journalButton);

        // Action listeners for radio buttons to change ComboBox items
        journalButton.addActionListener(e -> {
            categoryBox.removeAllItems();
            for (String category : journalCategories) {
                categoryBox.addItem(category);
            }
        });

        bookButton.addActionListener(e -> {
            categoryBox.removeAllItems();
            for (String category : bookCategories) {
                categoryBox.addItem(category);
            }
        });

        // Submit Button Logic
        submitButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String id = idField.getText().trim();
            String searchTerm = searchField.getText().trim().toLowerCase();
            int category = categoryBox.getSelectedIndex();

            // Error Handling: empty fields
            if (name.isEmpty() || id.isEmpty()) {
                errorArea.setText("Ошибка: Заполните все поля!");
                cardLayout.show(cardPanel, "error");
                return;
            }

            // Validate ticket number
            if (!isValidTicketNumber(id)) {
                errorArea.setText("Ошибка: Номер билета может содержать только буквы, цифры и знаки препинания.");
                cardLayout.show(cardPanel, "error");
                return;
            }
            
            if (!bookButton.isSelected() && !journalButton.isSelected()) {
                errorArea.setText("Ошибка: Выберите тип литературы (Книга или Журнал)!");
                cardLayout.show(cardPanel, "error");
                return;
            }

            // Result Generation Logic
            StringBuilder result = new StringBuilder("Привет, " + name + "!\nБилет: " + id + "\nВот вам доступные книжечки:\n"); 

            if (bookButton.isSelected()) {
            	
                    for (int i = 0; i < bookNames.length; i++) {
                        if (bookCategoryIndices[i] == category) {
                        	if (bookNames[i].toLowerCase().contains(searchTerm)) {
                            result.append("- ").append(bookNames[i]).append(" (").append(bookAuthors[i]).append(")\n");
                        	}
                        }
                    }
                    
                 // Если книги не найдены, показываем результат
                    if (result.toString().equals("Привет, " + name + "!\nБилет: " + id + "\nВот вам доступные книжечки:\n")) {
                        result.append("Книги по вашему запросу не найдены.");
                    }
                    
                
            } 
            
                // Add your journal result generation logic here (based on journalCategories)
            	
            	if (journalButton.isSelected()) {
                    for (int i = 0; i < journalNames.length; i++) {
                        if (journalCategoryIndices[i] == category) {
                        	if (journalNames[i].toLowerCase().contains(searchTerm)) {
                            result.append("- ").append(journalNames[i]).append(" (").append(journalAuthors[i]).append(")\n");
                        	}
                        }
                    }
                    
                 // Если journals найдены, показываем результат
                    if (result.toString().equals("Привет, " + name + "!\nБилет: " + id + "\nВот вам доступные книжечки:\n")) {
                        result.append("Журналы по вашему запросу не найдены.");
                    }
            }

            resultArea.setText(result.toString());
            cardLayout.show(cardPanel, "result");
        });//the end of lymbda

        // Back Button Logic
        backToInputFromResult.addActionListener(e -> cardLayout.show(cardPanel, "input"));
        backToInputFromError.addActionListener(e -> cardLayout.show(cardPanel, "input"));

        // Frame Setup
        frame.getContentPane().add(cardPanel);
        frame.setVisible(true);
    }
}
    
